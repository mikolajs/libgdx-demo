package pl.edu.osp


import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.{Input, Gdx, Game}
import com.badlogic.gdx.graphics.g2d.{SpriteBatch}
import com.badlogic.gdx.graphics.{OrthographicCamera, GL20}

class Libgdxdemo extends Game {
  private var batch:SpriteBatch = null
  private var subtitles:StartSubtitles = null
  private var torpedoShip:TorpedoShipGame = null
  private var state:Int = 0

  override def create(): Unit = {
    batch = new SpriteBatch()
    subtitles = new StartSubtitles
    torpedoShip = new TorpedoShipGame

  }


  override def resize(width: Int, height: Int) {
    torpedoShip.getViewport.update(width, height)
  }

  override def render():Unit = {
    Gdx.gl.glClearColor(1, 1, 1, 1)
    Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT)

    state match {
      case 0 => {
        batch.begin()
        subtitles.render(batch)
        batch.end()
        state = if(subtitles.end_?) 1 else 0
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE))  state = 1
      }
      case _ => {
        batch.setProjectionMatrix(torpedoShip.getCamera.projection)
        batch.setTransformMatrix(torpedoShip.getCamera.view)
        torpedoShip.render(batch)
      }
    }
  }

  override def dispose():Unit = {
    batch.dispose()
    subtitles.dispose()
  }

}
