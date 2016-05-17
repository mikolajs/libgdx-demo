package pl.edu.osp

import com.badlogic.gdx.{Gdx, Game}
import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.graphics.{GL20, GL30, Color}
;

class Libgdxdemo extends Game {
  private var batch:SpriteBatch = null
  private var font:BitmapFont = null
  var posX = 200
  var posY = 350
  val napis =
    """
      |Demo gry do nauki LibGDX
      |Podstawy pracy LibGDX
      |Demo gry do nauki LibGDX
      |Demo gry do nauki LibGDX
      |Demo gry do nauki LibGDX
      |Demo gry do nauki LibGDX
    """.stripMargin
  override def create(): Unit = {
    batch = new SpriteBatch()
    font = new BitmapFont()
    font.setColor(Color.CYAN)
    font.getData.scale(4f)
  }

  override def render():Unit = {
    Gdx.gl.glClearColor(1, 1, 1, 1)
    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT)
    posY += 3
    posX += 1
    font.getData.scale(-0.01f)

    batch.begin()
    if(posY < 1200) {
      font.draw(batch, napis, posX, posY)
    } else {
      font.getData.scaleX = 1f
      font.getData.scaleY = 1f
      font.draw(batch, "Koniec", 500, 350 )
    }
    batch.end()
  }

  override def dispose():Unit = {
    font.dispose()
    batch.dispose()
  }
}
