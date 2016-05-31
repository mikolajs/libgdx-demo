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
  var posY = -300f
  var scale = 1f
  val napisy = Array("LIBGDX-DEMO", "LibGDX nie jest", "silnikiem gier.", "Jest zbiorem narzedzi.",
    "Pozwala tworzyc gry na:", "Windows, Linux,", "iOS, Andoirda i HTML").reverse
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
    posY += 1
    batch.begin()
    batch.draw(texture, 0, 0)
    if(posY % 2 == 0) {
      scale *=0.999f
      //println("SCALE: " + font.getScaleX)
    }
    for(i <- 0 until napisy.length) {
      font.getData.setScale(scala.math.pow(scale, i.toDouble).toFloat)
      layout.setText(font,  napisy(i))

      //println(s"+++++++++ $i size of text ${napisy(i)} is:  ${layout.width}"  )
      font.draw(batch, napisy(i), (Gdx.graphics.getWidth - layout.width) / 2,
          posY + layout.height + i*layout.height * 2.0f)

    }


    batch.end()
  }

  override def dispose():Unit = {
    font.dispose()
    batch.dispose()
    texture.dispose()
  }
}
