plugins {
    kotlin("jvm") version "2.1.0"
    id("earth.terrarium.cloche") version "0.13.2"
}

repositories {
    cloche {
        mavenNeoforgedMeta()
        mavenNeoforged()
        mavenForge()
        mavenFabric()
        mavenParchment()
        librariesMinecraft()
        main()
    }
    mavenCentral()
    maven("https://maven.teamabnormals.com/")
    maven("https://api.modrinth.com/maven")
}

group = "com.rosemods"
version = "3.0.1"

cloche {
    mappings {
        official()
    }

    metadata {
        modId = "windswept"
        name = "Windswept"
        description = "A general expansion to snowy and forest areas of the game, incentivising players to explore and build in the new expanded areas"
        license = "All Rights Reserved"
        icon = "logo.png"

        author("Rose")
        author("Yape")
        contributor("Apollo (Fabric Port)")
    }

    singleTarget {
        forge {
            loaderVersion = "47.4.0"
            minecraftVersion = "1.20.1"
            mixins.from(file("src/main/windswept.mixins.json"))
            accessWideners.from(file("src/main/windswept.accesswidener"))

            dependencies {
                compileOnly("org.spongepowered:mixin:0.8.3")
                modRuntimeOnly("maven.modrinth:lithostitched:1.4.11-forge-1.20")
                implementation("com.teamabnormals:blueprint:1.20.1-7.1.3")
            }

            runs {
                client()
                server()
            }

            metadata {
                dependencies {
                    dependency {
                        modId = "blueprint"
                        required = true
                    }
                }
            }
        }
    }
}