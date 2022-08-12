package PlanesForTheWorty;

import lombok.Getter;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.*;
import java.util.stream.Collectors;

@Getter
public class PlanesTesting {

    List <Planes> litachokBayraktar = createPlanes(() -> new Planes("Bayraktarchik))", 200, 1000, 2500), 3);
    List <Planes> litachokKyivstar = createPlanes(() -> new Planes("KyivstarAir", 400, 3000, 11300), 3);

    public List<Planes> getLitachokBayraktar(){
        return litachokBayraktar;
    }
    public List<Planes> createPlanes(Supplier<Planes> supplier, int n){
        List<Planes> planes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            planes.add(supplier.get());
        }
        return planes;
    }

    public void changeLitachok(Planes litachok, Consumer<Planes> consumer){
        consumer.accept(litachok);
    }

    public double getAvarageData(List<Planes> litachkiList, Function<Planes, Double> function) {
        double result = 0.0;
        for (Planes planes : litachkiList) {
        result += function.apply(planes);
        }
        return result/litachkiList.size();
    }

    //Predicate
    @Test
    public void testLitachokSpeed(){
        List<Planes> litachkiActual;
        Predicate<Planes> litachokPredicate = litachok -> litachok.speed > 450;
        litachkiActual = getLitachokBayraktar().stream().filter(litachokPredicate).collect(Collectors.toList());
        litachkiActual.forEach(litachok -> {
            Assert.assertTrue(litachok.speed > 450);
        });
    }
    @Test
    public void testLitachokModel(){
        List<Planes> litachkiActual;
        Predicate<Planes> litachokPredicate = litachok -> Objects.equals(litachok.model, "Bayraktarchik))");
        litachkiActual = getLitachokBayraktar().stream().filter(litachokPredicate).collect(Collectors.toList());
        litachkiActual.forEach(litachok -> {
            Assert.assertEquals(litachok.model, "Bayraktarchik))");
        });
    }

    //Supplier
    @Test
    public void testCreateLitachok(){
        List<Planes> litakMriya = createPlanes(() -> new Planes("Mriya", 1000, 2500, 20000), 3);
        for (Planes litachki : litakMriya) {
            Assert.assertEquals(litachki.model, "Mriya");
            Assert.assertEquals(litachki.speed, 1000);
            Assert.assertEquals(litachki.maxHeight, 2500);
            Assert.assertEquals(litachki.maxFlyDistance, 20000);
        }
    }
    @Test
    public void testCreateLitachokSize(){
        List<Planes> litakMriya = createPlanes(() -> new Planes("Mriya", 1000, 2500, 20000), 5);
        Assert.assertEquals(litakMriya.size(), 5);
    }

    //Consumer

    @Test
    public void testChangeLitachokHeight(){
        changeLitachok(litachokBayraktar.get(0), litachokToChange -> litachokToChange.maxHeight = 30000);
        Assert.assertEquals(litachokBayraktar.get(0).maxHeight, 30000);
    }

    @Test
    public void testChangeLitachokSpeed(){
        changeLitachok(litachokBayraktar.get(0), litachokToChange -> litachokToChange.speed = 1000);
        Assert.assertEquals(litachokBayraktar.get(0).speed, 1000);
    }

    //Function

    @Test
    public void testAvaarageSpeed() {
        Assert.assertEquals(getAvarageData(litachokBayraktar, planes -> (double)planes.speed), 200.0);
    }

    @Test
    public void testAvaarageHeight() {
        Assert.assertEquals(getAvarageData(litachokBayraktar, planes -> (double)planes.maxHeight), 1000.0);
    }
}

