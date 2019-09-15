package me.saket.compose.shared.db

import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import com.soywiz.klock.parse
import com.squareup.sqldelight.ColumnAdapter

/**
 * For UTC date times.
 */
class DateTimeAdapter : ColumnAdapter<DateTime, String> {

  override fun decode(databaseValue: String): DateTime =
    DateFormat.FORMAT1.parse(databaseValue).utc

  override fun encode(value: DateTime) =
    value.toString(DateFormat.FORMAT1)
}