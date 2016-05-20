package pl.edu.osp

import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter
import com.badlogic.gdx.{Gdx, Game}
import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.graphics.{Texture, GL20, Color}

class Libgdxdemo extends Game {
  private var batch:SpriteBatch = null
  private var texture:Texture = null

  var posX = 0
  var posY = 0
  var claps = 0
  val napisy = Array("LIBGDX-DEMO", "LibGDX nie jest", "silnikiem gier.", "Jest zbiorem narzedzi.",
    "Pozwala tworzyc gry na:", "Windows, Linux,", "iOS, Andoirda i HTML").reverse
  private var fonts:Array[BitmapFont] = new Array(napisy.length)
  override def create(): Unit = {
    batch = new SpriteBatch()
    texture = new Texture(Gdx.files.internal("data/galaxy.jpg"))
    val generator = new FreeTypeFontGenerator(Gdx.files.internal("data/Comic_Sans_MS_Bold.ttf"))
    val parameter = new FreeTypeFontParameter()
    parameter.size = 80
    parameter.borderColor = Color.BLACK
    parameter.borderWidth = 3
    parameter.color = Color.YELLOW
    for(i <- 0 until napisy.length) fonts(i) = generator.generateFont(parameter)
    generator.dispose()
  }

  override def render():Unit = {
    Gdx.gl.glClearColor(1, 1, 1, 1)
    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT)
   // posY += 1
    batch.begin()
    batch.draw(texture, 0, 0)
    for(i <- 0 until napisy.length) {
      fonts(i).draw(batch, napisy(i), 0, 100 + i*100)
    }
    batch.end()
  }

  override def dispose():Unit = {
    for(i <- 0 until fonts.length) fonts(i).dispose()
    batch.dispose()
    texture.dispose()
  }
}
