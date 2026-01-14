plugins {
	kotlin("jvm") version libs.versions.kotlin.get()
	alias(libs.plugins.run.paper)
}

kotlin {
	jvmToolchain(21)
}

repositories {
	mavenCentral()
	maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
	maven("https://oss.sonatype.org/content/repositories/snapshots/")
	maven("https://repo.papermc.io/repository/maven-public/")
	maven("https://repo.skriptlang.org/releases")
	maven("https://maven.enginehub.org/repo/")
}

dependencies {
	compileOnly(libs.spigot.api)
	implementation(libs.kotlin.stdlib)
	implementation(libs.worldedit.api) {
		exclude(module = "bstats-bukkit")
	}

	compileOnly(libs.skript)

	implementation(platform(libs.fawe.bom))
	compileOnly(libs.fawe.core)
	compileOnly(libs.fawe.bukkit)
}

tasks {
	runServer {
		minecraftVersion("1.21.11")
		jvmArgs("-Xmx2G", "-Xms2G", "-Dcom.mojang.eula.agree=true")

		downloadPlugins {
			modrinth("fastasyncworldedit", "2.15.0")
			github("SkriptLang", "Skript", "2.14.0-pre2", "Skript-2.14.0-pre2.jar")
		}
	}

	processResources {
		val properties = mapOf(
			"version" to project.version,
			"kotlin" to libs.kotlin.stdlib.get().toString()
		)
		expand(properties)
	}
}
