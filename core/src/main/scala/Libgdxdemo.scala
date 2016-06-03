package pl.edu.osp

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.{Gdx, Game}
import com.badlogic.gdx.graphics.g2d.{GlyphLayout, BitmapFont, SpriteBatch}
import com.badlogic.gdx.graphics.{Texture, GL20, Color}

class Libgdxdemo extends Game {
  private var batch:SpriteBatch = null
  private var texture:Texture = null
  private var layout:GlyphLayout = null
  private var font:BitmapFont = null
  var scale = 1f
  val napisy = Array("LIBGDX-DEMO", "LibGDX nie jest", "silnikiem gier.", "Jest zbiorem narzedzi.",
    "Pozwala tworzyc gry na:", "Windows, Linux,", "iOS, Andoirda i HTML")
  val positions = new Array[Int](napisy.length)
  for(i <- 0 until napisy.length) {
    positions(i) = -110 * i
  }


  override def create(): Unit = {
    batch = new SpriteBatch()
    texture = new Texture(Gdx.files.internal("data/galaxy.jpg"))
    val generator = new FreeTypeFontGenerator(Gdx.files.internal("data/Comic_Sans_MS_Bold.ttf"))
    val parameter = new FreeTypeFontParameter()
    parameter.size = 80
    parameter.borderColor = Color.BLACK
    parameter.borderWidth = 3
    parameter.color = Color.YELLOW
    font = generator.generateFont(parameter)
    generator.dispose()

    layout = new GlyphLayout()
  }

  override def render():Unit = {
    Gdx.gl.glClearColor(1, 1, 1, 1)
    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT)
    batch.begin()
    batch.draw(texture, 0, 0)
    for(i <- 0 until napisy.length) {
      val pos = positions(i)
      if(pos >=  0 && pos <= 960) {
        val Y = (pos / 1.414213562).toFloat
        val mL = pos
        val mR = marginR(Y)
        font.getData.setScale(
          (Gdx.graphics.getWidth - mL - mR).toFloat / (Gdx.graphics.getWidth - 180).toFloat
        )
        layout.setText(font,  napisy(i))
        font.draw(batch, napisy(i), (Gdx.graphics.getWidth + mL - (layout.width + mR )) / 2, Y)
      }
      positions(i) += 1
    }


    batch.end()
  }

  override def dispose():Unit = {
    font.dispose()
    batch.dispose()
    texture.dispose()
  }

  private def marginR(y: Float):Int = (180.0f - 0.257142857f*y).toInt

}
