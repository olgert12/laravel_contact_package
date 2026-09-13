package com.pixevo.albtv

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
import androidx.media3.exoplayer.ExoPlayer

class MainActivity : AppCompatActivity() {
    private var player: ExoPlayer? = null

    private val channels = listOf(
        Channel("Euronews Albania", "Lajme", "https://euronews.al/live/"),
        Channel("A2 CNN", "Lajme", "https://a2news.com/"),
        Channel("Ora News", "Lajme", "https://www.oranews.tv/"),
        Channel("Report TV", "Lajme", "https://report-tv.al/report_live"),
        Channel("News24", "Lajme", "https://www.news24.al/livestream/"),
        Channel("Vizion Plus", "TV", "https://www.vizionplus.tv/livestream/")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showChannelList()
    }

    private fun showChannelList() {
        player?.release(); player = null
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.rgb(11,13,16))
            setPadding(24)
        }
        root.addView(TextView(this).apply {
            text = "AlbTV"
            textSize = 30f
            setTextColor(Color.WHITE)
            setPadding(8, 8, 8, 2)
        })
        root.addView(TextView(this).apply {
            text = "Kanale shqiptare • MVP personal"
            textSize = 14f
            setTextColor(Color.LTGRAY)
            setPadding(8, 0, 8, 18)
        })

        channels.forEach { ch ->
            root.addView(LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(18)
                background = android.graphics.drawable.GradientDrawable().apply {
                    cornerRadius = 28f
                    setColor(Color.rgb(28,31,36))
                }
                val p = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                p.setMargins(0,0,0,14); layoutParams = p
                addView(TextView(this@MainActivity).apply {
                    text = ch.name
                    textSize = 20f
                    setTextColor(Color.WHITE)
                })
                addView(TextView(this@MainActivity).apply {
                    text = ch.category
                    textSize = 13f
                    setTextColor(Color.rgb(160,165,175))
                })
                setOnClickListener { openWebFallback(ch) }
            })
        }
        val scroll = ScrollView(this).apply { addView(root) }
        setContentView(scroll)
    }

    private fun openWebFallback(ch: Channel) {
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.BLACK)
        }
        layout.addView(Button(this).apply {
            text = "← Kanale"
            setOnClickListener { showChannelList() }
        })
        layout.addView(TextView(this).apply {
            text = ch.name
            textSize = 22f
            gravity = Gravity.CENTER
            setTextColor(Color.WHITE)
            setPadding(10,24,10,12)
        })
        layout.addView(TextView(this).apply {
            text = "Ky MVP përdor vetëm burime zyrtare publike. Për versionin e parë, kur broadcaster-i nuk ekspozon URL HLS direkte, hapet faqja zyrtare live në browser."
            setTextColor(Color.LTGRAY)
            setPadding(24)
        })
        layout.addView(Button(this).apply {
            text = "Hap livestream-in zyrtar"
            setOnClickListener {
                startActivity(android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse(ch.url)))
            }
        })
        setContentView(layout)
    }

    override fun onDestroy() {
        player?.release(); player = null
        super.onDestroy()
    }
}

data class Channel(val name: String, val category: String, val url: String)
