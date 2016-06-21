package pl.edu.osp

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{OrthographicCamera, Texture}
import com.badlogic.gdx.graphics.g2d.{Animation, TextureRegion, SpriteBatch, Batch}
import com.badlogic.gdx.utils.viewport.FitViewport

class TorpedoShipGame {
  private val seaSmall: Texture = new Texture(Gdx.files.internal("data/sea_title.png"))
  private val seaTexs = new TextureRegion(seaSmall).split(100, 100)
  val animation = new Animation(0.1f,seaTexs(0)(0), seaTexs(0)(1))
  animation.setPlayMode(Animation.PlayMode.LOOP)

  private val ship = new Ship
  private val camera = new OrthographicCamera
  camera.position.set(600, 350, 0)
  camera.update()
  private val viewport = new FitViewport(1200, 700, camera)
  var animationTimer = 0f
  def render(batch: SpriteBatch): Unit = {
    val bgTex = animation.getKeyFrame(animationTimer)
    animationTimer += 0.4f
    batch.begin()
    (0 until 84).foreach(i => batch.draw(bgTex, (i%12)*100, (i / 12)*100 ))
    ship.render(batch)
  }


  def getCamera = camera
  def getViewport = viewport
}
