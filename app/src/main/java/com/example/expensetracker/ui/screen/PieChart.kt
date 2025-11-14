package com.example.expensetracker.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.model.CategoryData
import kotlin.math.cos
import kotlin.math.sin


@Composable
fun PieChart(data: List<CategoryData>) {
    Canvas(
        modifier = Modifier
            .size(280.dp)
            .padding(32.dp)
    ) {
        val total = data.sumOf { it.percentage }
        var startAngle = -90f

        data.forEach { category ->
            val sweepAngle = (category.percentage / total * 360f).toFloat()

            // Draw pie slice
            drawArc(
                color = category.color,
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
                topLeft = Offset.Zero,
                size = Size(size.width, size.height)
            )

            // Draw border between slices
            drawArc(
                color = Color(0xFF1E1E1E),
                startAngle = startAngle,
                sweepAngle = sweepAngle,
                useCenter = true,
                style = Stroke(width = 2f),
                topLeft = Offset.Zero,
                size = Size(size.width, size.height)
            )

            startAngle += sweepAngle
        }
    }

    // Labels
    Box(
        modifier = Modifier.size(280.dp),
        contentAlignment = Alignment.Center
    ) {
        data.forEachIndexed { index, category ->
            val angle = -90f + data.take(index).sumOf { it.percentage } / data.sumOf { it.percentage } * 360f +
                    (category.percentage / data.sumOf { it.percentage } * 360f / 2f)
            val radius = 140f
            val x = (radius * cos(Math.toRadians(angle.toDouble()))).toFloat()
            val y = (radius * sin(Math.toRadians(angle.toDouble()))).toFloat()

            Box(
                modifier = Modifier
                    .offset(x = (x * 0.8f).dp, y = (y * 0.8f).dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${category.emoji} ${category.name}",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 12.sp
                    )
                    Text(
                        text = "${String.format("%.1f", category.percentage)} %",
                        color = MaterialTheme.colorScheme.onSurface,
                        fontSize = 11.sp
                    )
                }
            }
        }
    }
}