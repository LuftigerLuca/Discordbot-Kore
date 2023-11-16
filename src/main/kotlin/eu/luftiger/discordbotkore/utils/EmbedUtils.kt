package eu.luftiger.discordbotkore.utils

import eu.luftiger.discordbotkore.modal.KoreEmbedField
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color
import java.time.Instant

object EmbedUtils {

    fun generateEmbed(
        title: String,
        description: String? = null,
        color: Color = Color.MAGENTA,
        fields: Set<KoreEmbedField>? = null,
        authorIcon: String? = null,
        authorText: String? = null,
        thumbnail: String? = null,
        footer: String? = null,
        timestamp: Boolean = true,
    ): MessageEmbed {
        val embed = EmbedBuilder()

        with(embed) {
            setTitle(title)
            setColor(color)

            if (description != null) setDescription(description)
            fields?.forEach { addField(it.name, it.value, it.inline) }
            if (authorIcon != null && authorText != null) setAuthor(authorText, null, authorIcon)
            if (authorText != null && authorIcon == null) setAuthor(authorText, null, null)
            if (authorText == null && authorIcon != null) setAuthor(null, null, authorIcon)
            if (thumbnail != null) setThumbnail(thumbnail)
            if (footer != null) setFooter(footer)
            if (timestamp) setTimestamp(Instant.now())
        }
        return embed.build()
    }
}