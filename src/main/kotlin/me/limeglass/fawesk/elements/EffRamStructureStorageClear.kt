package me.limeglass.fawesk.elements

import ch.njol.skript.doc.Name
import ch.njol.skript.lang.Expression
import ch.njol.skript.lang.SkriptParser
import ch.njol.skript.util.AsyncEffect
import ch.njol.util.Kleenean
import org.bukkit.event.Event
import org.skriptlang.skript.registration.SyntaxInfo
import org.skriptlang.skript.registration.SyntaxRegistry

@Name("Clear RAM Structure Storage")
class EffRamStructureStorageClear : AsyncEffect() {

	companion object {
		fun register(registry: SyntaxRegistry) {
			registry.register(
				SyntaxRegistry.EFFECT,
				SyntaxInfo.builder(EffRamStructureStorageClear::class.java)
					.addPattern("clear [the] [fawesk] ram [structure] storage")
					.build()
			)
		}
	}

	override fun init(
		p0: Array<out Expression<*>?>?,
		p1: Int,
		p2: Kleenean?,
		p3: SkriptParser.ParseResult?
	): Boolean {
		return true
	}

    override fun execute(event: Event?) {
        ExprRamStructureStorage.table.clear()
    }

    override fun toString(event: Event?, debug: Boolean): String? {
        return "clear the ram structure storage"
    }
}
