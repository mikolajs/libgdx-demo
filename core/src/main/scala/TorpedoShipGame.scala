package pl.edu.osp

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{OrthographicCamera, Texture}
import com.badlogic.gdx.graphics.g2d.{TextureRegion, SpriteBatch, Batch}
import com.badlogic.gdx.utils.viewport.FitViewport

class TorpedoShipGame {
  private val sea: Texture = new Texture(Gdx.files.internal("data/sea.png"))
  private val seaSmall: Texture = new Texture(Gdx.files.internal("data/sea_title.png"))
  private val seaReg = new TextureRegion(seaSmall)
  private val ship = new Ship
  private val camera = new OrthographicCamera
  camera.position.set(600, 350, 0)
  camera.update()
  private val viewport = new FitViewport(1200, 700, camera)

  def render(batch: SpriteBatch): Unit = {
    batch.begin()
    batch.draw(sea, 0, 0)
    ship.render(batch)
  }

  private def drawBackground(batch: StartSubtitles): Unit = {
    
  }

  def getCamera = camera
  def getViewport = viewport
}
