package net.codava.virtualspawner.api.utils;

import java.util.Objects;

public class EasyLocation {
   private String string;
   private int x;
   private int y;
   private int z;

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         EasyLocation var2 = (EasyLocation)o;
         return this.x == var2.x && this.y == var2.y && this.z == var2.z && Objects.equals(this.string, var2.string);
      } else {
         return false;
      }
   }

   public int hashCode() {
      int var1 = this.string.hashCode();
      var1 = 31 * var1 + this.x;
      var1 = 31 * var1 + this.y;
      var1 = 31 * var1 + this.z;
      return var1;
   }

   public EasyLocation(String string, int x, int y, int z) {
      this.string = string;
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public String getString() {
      return this.string;
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getZ() {
      return this.z;
   }

   public void setString(String string) {
      this.string = string;
   }

   public void setX(int x) {
      this.x = x;
   }

   public void setY(int y) {
      this.y = y;
   }

   public void setZ(int z) {
      this.z = z;
   }
}
