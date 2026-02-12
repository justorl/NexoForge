## NexoForge
Code-driven Nexo (WIP)

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
To register your NexoForge item, you need to use YamlWriter in the onEnable like this:
```kt
YamlWriter(this).writeToString(item, "legendary.yml")
YamlWriter(this).writeToString(itemsList, "legendary.yml")
YamlWriter(this).writeToString(
    item1,
    item2,
    "can/contain/subfolders.yml"
)
```

You can register items after the onEnable stage, but you must reload Nexo configs for them to appear

## Shading
Shading is not recommended. If you do it, make sure to relocate NexoForge