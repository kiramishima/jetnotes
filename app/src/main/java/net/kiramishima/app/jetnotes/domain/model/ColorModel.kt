package net.kiramishima.app.jetnotes.domain.model

import net.kiramishima.app.jetnotes.data.database.model.ColorDbModel

/**
 * Model class for one Color
 */
data class ColorModel(
  val id: Long,
  val name: String,
  val hex: String
) {

  companion object {

    val DEFAULT = with(ColorDbModel.DEFAULT_COLOR) { ColorModel(id, name, hex) }
  }
}
