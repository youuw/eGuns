package eGuns.Listenery;

public enum Amunicja {
      amoAK47(6), amoM16(5), amoM14(5), amoSG(3), amoM9(1);
      private int damage;
      
      Amunicja(int damage)
      {
      this.damage = damage;
      }
      
      public int getDamage()
      {
      return this.damage;
      }
      }
    
