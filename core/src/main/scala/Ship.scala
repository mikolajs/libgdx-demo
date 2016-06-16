package pl.edu.osp

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.{Color, Colors, Texture}
import com.badlogic.gdx.graphics.g2d.{SpriteBatch, GlyphLayout, BitmapFont, Batch}

class Ship {
  val maxDirGun = 135f
  val maxDirTorp = 65f
  val maxPower = 20f
  val minPower = -10f
  val maxRudder = 20f
  var speed = 0f
  var power = 0f
  var HP = 100f
  var rudder = 0f
  var dir = 0f
  var torpedoDir = 0f
  var gunDir = 0f
  private  val hullTex:Texture = new Texture(Gdx.files.internal("data/shiphull.png"))
  private  val gunTex:Texture = new Texture(Gdx.files.internal("data/shipgun.png"))
  private  val torpTex:Texture = new Texture(Gdx.files.internal("data/shiptorp.png"))
  private val font = new BitmapFont()
  font.setColor(Color.RED)
  private val layout = new GlyphLayout()
  font.getData.setScale(1f)

  def render(batch: SpriteBatch): Unit  = {
    val centerX = Gdx.graphics.getWidth/2
    val centerY = Gdx.graphics.getHeight/2
    batch.draw(hullTex, centerX - hullTex.getWidth/2,  centerY - hullTex.getHeight/2)
    batch.draw(gunTex, centerX - gunTex.getWidth/2,  centerY - gunTex.getHeight/2 + 19)
    batch.draw(torpTex, centerX - torpTex.getWidth/2,  centerY - torpTex.getHeight/2 - 20)
  }

  def drawInfo(batch: SpriteBatch): Unit ={
    font.draw(batch, "Napis", 10, 100)
  }

  def takeKeys: Unit = {

  }
}
