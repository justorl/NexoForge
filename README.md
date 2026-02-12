## NexoForge
Code-driven Nexo! WIP

## Example item
```kt
        nexoItem("legendary_sword") {
            material(Material.DIAMOND_SWORD)
            itemName("<red>Legendary Sword")
            lore(
                "<gray>A great sword..",
                "",
                "Attack Speed: 0.15",
                "Attack Damage: 10"
            )
            
            components {
                maxDamage(2000)
                
                weapon {
                    damagePerAttack(10)
                }
            }
            
            attributeModifiers {
                attribute(Attribute.ATTACK_DAMAGE) {
                    amount(10.0)
                    operation(0)
                    slot(Slots.HAND)
                }
                attribute(Attribute.ATTACK_SPEED) {
                    amount(0.15)
                    operation(1)
                    slot(Slots.HAND)
                }
            }
            
            pack {
                texture("custom/legendary_sword")
                customModelData(1001)
            }
        }
```

## Registration
To register your NexoForgeItem you need to use YamlWriter in onEnable like this:
```kt
    YamlWriter(this).writeToString(item, "weapons/legendarys.yml")
    YamlWriter(this).writeToString(itemsList, "weapons/legendarys.yml")
    YamlWriter(this).writeToString(
        item1,
        item2,
        "weapons/legendary.yml"
    )
```

You can register your items after onEnable stage, but you will need to reload nexo configs to item to show up

## How to use it?
### External plugin
Compile plugin yourself, or use pre-compiled binaries from github releases and put it like a normal plugin. Example kotlin gradle configuration:
```kt
    
```
### Shading
Shade it using jitpack. Example kotlingradle configuration:
```kt
    
```