package pl.edu.osp

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.{SpriteBatch, Batch}

class TorpedoShipGame {
  private val sea: Texture = new Texture(Gdx.files.internal("data/sea.png"))
  private val ship = new Ship

  def render(batch: SpriteBatch): Unit = {
    batch.draw(sea, 0, 0)
    ship.render(batch)
    ship.drawInfo(batch)
  }
}
