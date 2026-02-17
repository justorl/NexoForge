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

    recipe {
        shaped {
            shape(
                "NNN",
                "NSN",
                "NNN"
            )
            ingredient('N', Material.NETHER_STAR)
            ingredient('S', Material.NETHERITE_SWORD)
            amount(1)
        }
    }

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
To register your NexoForge item, you need to do something like this:
```kt
NexoForge.get()?.registerItem(item, "legendary.yml")
NexoForge.get()?.registerItem(itemsList, "legendary.yml")
NexoForge.get()?.registerItem(
    item1,
    item2,
    "can/contain/subfolders.yml"
)
```

If you're shading, you need to do something like that:
```kt
val nexoForge = NexoForge(this)

override fun onEnable() {
    nexoForge.onEnable()
    nexoForge.registerItem(item, "legendary.yml")
}

override fun onDisable() {
    nexoForge.onDisable()
}
```

You can register items after the onEnable stage, but you must reload Nexo configs for them to appear.

## Shading
Make sure to relocate NexoForge! Don't use NexoForge.get() if you are shading.