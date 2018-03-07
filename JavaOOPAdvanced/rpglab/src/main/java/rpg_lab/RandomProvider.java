package rpg_lab;

import java.util.Random;

public interface RandomProvider {

    int next(int max);

    class Impl{
        private Random random;

        public Impl(){
            this.random = new Random();
        }

        public int next(int max){
           return this.random.nextInt(max);
        }

    }
}
