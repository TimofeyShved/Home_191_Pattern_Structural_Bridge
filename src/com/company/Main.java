package com.company;

public class Main {

    public static void main(String[] args) {
        ICar car = new ToyotaCar(new CarBridge());
        car.drive();

        ITrack track = new ToyotaTrack(new TrackBridge());
        track.iBridge.drive();
    }
}

/*      Пример как делать нельзя так как здесь 3 уровня иерархии (」°ロ°)」

interface ICar {void drive();}
interface ITrack {void drive();}

        Создавать кучу классов для каждого интерфейса

class ToyotaCar implements ICar {}
class AudiCar implements ICar {}

class ToyotaTrack implements ITrack {}
class AudiTrack implements ITrack {}

 */

// а здесь 2 уровня и нужно выстраивать именно таким образом
// но кода в разы больше  (￣ ￣|||)

interface IBridge{
    void drive();
}

// Тип авто (например цвет)
class CarBridge implements IBridge{
    @Override
    public void drive() {
        System.out.println("drive Car");
    }
}

class TrackBridge implements IBridge{
    @Override
    public void drive() {
        System.out.println("drive Track");
    }
}

// Виды авто (например фигуры)

abstract class ICar {
    IBridge iBridge;

    public ICar(IBridge iBridge){
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

abstract class ITrack {
    IBridge iBridge;

    public ITrack(IBridge iBridge){
        this.iBridge = iBridge;
    }

    public abstract void drive();
}

// авто

class ToyotaCar extends ICar {
    public ToyotaCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class AudiCar extends ICar {
    public AudiCar(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}


class ToyotaTrack extends ITrack {
    public ToyotaTrack(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}

class AudiTrack extends ITrack {
    public AudiTrack(IBridge iBridge) {
        super(iBridge);
    }

    @Override
    public void drive() {
        System.out.println("drive Audi");
    }
}