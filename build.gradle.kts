plugins {
    kotlin("jvm") version "2.1.0"
    id("earth.terrarium.cloche") version "0.11.0"
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
    maven ("https://raw.githubusercontent.com/Fuzss/modresources/main/maven/")
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
        fabric {
            loaderVersion = "0.16.13"
            minecraftVersion = "1.20.1"
            mixins.from(file("src/main/windswept.mixins.json"))
            accessWideners.from(file("src/main/windswept.accesswidener"))

            dependencies {
                fabricApi("0.92.6")
                modRuntimeOnly("maven.modrinth:lithostitched:1.4.11-fabric-1.20")
                implementation("fuzs.forgeconfigapiport:forgeconfigapiport-fabric:8.0.2")
            }

            includedClient()
            runs {
                client()
                server()
            }

            metadata {
                dependencies {
                    dependency {
                        modId = "lithostitched"
                        required = true
                    }
                }

                entrypoint("main") {
                    value = "com.rosemods.windswept.core.Windswept"
                }

                entrypoint("client") {
                    value = "com.rosemods.windswept.core.WindsweptClient"
                }
            }
        }
    }
}