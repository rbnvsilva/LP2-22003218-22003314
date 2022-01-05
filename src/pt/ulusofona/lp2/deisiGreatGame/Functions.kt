package pt.ulusofona.lp2.deisiGreatGame

enum class CommandType {
    GET, POST
}

fun getFunctions(manager: GameManager, args: List<String>): String? {
    when (args[0]) {
        "PLAYER" -> return getPlayer(manager, args)
        "PLAYERS_BY_LANGUAGE" -> return playersByLanguage(manager, args)
        "POLYGLOTS" -> return polyglots(manager, args)
        "MOST_USED_POSITIONS" -> return mostUsedPositions(manager, args)
        "MOST_USED_ABYSSES" -> return mostUsedAbysses(manager, args)
    }

    return null
}

fun postFunctions(manager: GameManager, args: List<String>): String? {
    when (args[0]) {
        "MOVE" -> return move(manager, args)
        "ABYSS" -> return abyss(manager, args)
    }

    return null
}

fun getPlayer(manager: GameManager, args: List<String>): String? {
    if (manager.getProgrammers(true) != null) {
        if (manager.getProgrammers(true).none { it.name.split(" ")[0] == args[1] }) {
            return "Inexistent player"
        }
        return manager.getProgrammers(true).filter { it.name.split(" ")[0] == args[1] }
            .toString().replace("[", "").replace("]", "")
    }

    return "Inexistent player"
}

fun playersByLanguage(manager: GameManager, args: List<String>): String? {
    if (manager.getProgrammers(true) != null) {
        if (manager.getProgrammers(true).none { it.languages.contains(args[1]) }) {
            return ""
        }
        return manager.getProgrammers(true).filter { it.languages.contains(args[1]) }
            .joinToString(",") { it.name }
    }

    return ""
}

fun polyglots(manager: GameManager, args: List<String>): String? {
    if (manager.getProgrammers(true) != null) {
        return manager.getProgrammers(true).filter { it.languages.size > 1 }
            .sortedWith { p1, p2 -> p1.languages.size - p2.languages.size }
            .joinToString("\n") { "${it.name}:${it.languages.size}" }
    }

    return ""
}

fun mostUsedPositions(manager: GameManager, args: List<String>): String? {
    return manager.sortPositions(manager.positions).take(args[1].toInt()).joinToString("\n")
}

fun mostUsedAbysses(manager: GameManager, args: List<String>): String? {
    return manager.sortAbysse(manager.abysses).take(args[1].toInt()).joinToString("\n")
}

fun move(manager: GameManager, args: List<String>): String? {
    if (manager.getProgrammers(false) != null && manager.abyssesOrTools != null) {
        manager.getProgrammers(false)
            .filter {it.id == manager.currentPlayerID}[0].move(args[1].toInt(), manager.size)
        return if (manager.abyssesOrTools.none { it.getPos() == manager.getProgrammers(false)
                .filter { it.id == manager.currentPlayerID }[0].pos}) {
            "OK"
        } else {
            manager.abyssesOrTools.filter {it.getPos() == manager.getProgrammers(false)
                .filter {it.id == manager.currentPlayerID}[0].pos}[0].message()
        }
    }
    return ""
}

fun abyss(manager: GameManager, args: List<String>): String? {
    if (manager.abyssesOrTools != null) {
        return if (manager.abyssesOrTools.none { it.getPos() == args[2].toInt() }) {
            manager.abyssesOrTools.add(Abyss(args[1].toInt(), args[2].toInt()))
            "OK"
        } else {
            "Position is occupied"
        }
    }

    return ""
}

fun escolheFuncao(commandType: CommandType) : ((GameManager, List<String>) -> String?) {
    return when (commandType) {
        CommandType.GET -> :: getFunctions
        CommandType.POST -> :: postFunctions
    }
}

fun router() : (CommandType) -> ((GameManager, List<String>) -> String?)? {
    return :: escolheFuncao
}