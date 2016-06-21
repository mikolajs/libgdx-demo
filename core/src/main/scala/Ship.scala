package pl.edu.osp

import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.{Input, Gdx}
import com.badlogic.gdx.graphics.{Color, Texture}
import com.badlogic.gdx.graphics.g2d.{SpriteBatch, GlyphLayout, BitmapFont}

case class Center(var x: Float, var y: Float)

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
  private val shape = new ShapeRenderer
  private val font = new BitmapFont()
  font.setColor(Color.RED)
  private val layout = new GlyphLayout()
  font.getData.setScale(1f)

  def render(batch: SpriteBatch): Unit  = {
    val shipCenter = Center(Gdx.graphics.getWidth/2 , Gdx.graphics.getHeight/2)
    val gunCenter = Center(shipCenter.x, shipCenter.y + 19f )
    val torpCenter = Center(shipCenter.x, shipCenter.y - 20f )
    batch.draw(hullTex, shipCenter.x - hullTex.getWidth/2,  shipCenter.y - hullTex.getHeight/2)
    batch.draw(gunTex, gunCenter.x - gunTex.getWidth/2,  gunCenter.y - gunTex.getHeight/2) //,
     // gunCenter.x, gunCenter.y, gunTex.getWidth, gunTex.getHeight, 1f, 1f, 90f)
    batch.draw(torpTex, torpCenter.x - torpTex.getWidth/2,  torpCenter.y - torpTex.getHeight/2)
    drawInfo(batch)
    batch.end()
    shape.begin(ShapeRenderer.ShapeType.Line)
    shape.setColor(Color.RED)
    shape.line(gunCenter.x,  gunCenter.y,  gunCenter.x+ 20f, gunCenter.y+20f)
    shape.end()

    takeKeys
  }

  def drawInfo(batch: SpriteBatch): Unit ={
    font.draw(batch, "Napis", 10, 100)
  }

  private def takeKeys(): Unit = {
    if(Gdx.input.isKeyPressed(Input.Keys.W)) println("W key pressed")
    if(Gdx.input.isKeyPressed(Input.Keys.A)) println("A key pressed")
    if(Gdx.input.isKeyPressed(Input.Keys.S)) println("S key pressed")
    if(Gdx.input.isKeyPressed(Input.Keys.D)) println("D key pressed")
  }
}
