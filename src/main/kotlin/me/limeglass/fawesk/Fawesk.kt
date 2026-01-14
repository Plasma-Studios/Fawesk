package me.limeglass.fawesk

import ch.njol.skript.Skript
import me.limeglass.fawesk.elements.*
import org.bukkit.plugin.java.JavaPlugin
import org.skriptlang.skript.addon.AddonModule
import org.skriptlang.skript.addon.SkriptAddon

class Fawesk : JavaPlugin() {

	override fun onEnable() {
		val addon = Skript.instance().registerAddon(this.javaClass, "Fawesk")
		addon.loadModules(Fawesk);
		addon.localizer().setSourceDirectories("lang", this.dataFolder.resolve("lang").canonicalPath)
		DefaultClasses.register()
	}

	internal companion object : AddonModule {
		override fun load(addon: SkriptAddon?) {
			val registry = addon!!.syntaxRegistry()
			EffPasteSchematic.register(registry)
			EffRamStructureStorageClear.register(registry)
			EffSaveSchematic.register(registry)
			ExprBlocks.register(registry)
			ExprLocations.register(registry)
			ExprRamStructureStorage.register(registry)
			ExprSchematicBlocks.register(registry)
		}

		override fun name(): String = "Fawesk Module"
	}
}
