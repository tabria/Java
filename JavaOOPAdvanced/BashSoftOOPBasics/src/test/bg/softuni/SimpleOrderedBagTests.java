package test.bg.softuni;

import main.bg.softuni.contracts.SimpleOrderedBag;
import main.bg.softuni.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp() {
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyCtor() {
        this.names = new SimpleSortedList<>(String.class);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialCapacity() {
        this.names = new SimpleSortedList<>(String.class, 20);
        Assert.assertEquals(20, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithInitialComparer() {
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER);
        Assert.assertEquals(16, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testCtorWithAllParams() {
        this.names = new SimpleSortedList<>(String.class, String.CASE_INSENSITIVE_ORDER, 30);
        Assert.assertEquals(30, this.names.capacity());
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testAddIncreasesSize() {
        this.names.add("Pesho");
        Assert.assertEquals(1, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullThrowsException() {
        this.names.add(null);
    }

    @Test
    public void testAddUnsortedDataIsHeldSorted() {
        this.names.add("Stamat");
        this.names.add("Gosho");
        this.names.add("Pesho");
        Iterator<String> iterator = this.names.iterator();
        Assert.assertEquals("Gosho", iterator.next());
        Assert.assertEquals("Pesho", iterator.next());
        Assert.assertEquals("Stamat", iterator.next());
    }

    @Test
    public void testAddingMoreThanInitialCapacity() {
        for (int i = 0; i < 17; i++) {
            this.names.add("Pesho");
        }
        Assert.assertEquals(17, this.names.size());
        Assert.assertNotEquals(16, this.names.capacity());
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "Pesho", "Gosho");
        this.names.addAll(collection);
        Assert.assertEquals(2, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddingAllFromNullThrowsException() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "Gosho", null, "Pesho");
        this.names.addAll(collection);
    }

    @Test
    public void testAddAllKeepsSorted() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "Pesho", "Gosho", "Stamat");
        this.names.addAll(collection);
        Iterator<String> iterator = this.names.iterator();
        Assert.assertEquals("Gosho", iterator.next());
        Assert.assertEquals("Pesho", iterator.next());
        Assert.assertEquals("Stamat", iterator.next());
    }

    @Test
    public void testRemoveValidElementDecreasesSize() {
        this.names.add("Pesho");
        this.names.remove("Pesho");
        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne() {
        this.names.add("Ivan");
        this.names.add("Pesho");
        this.names.remove("Ivan");
        Assert.assertEquals("Pesho", this.names.iterator().next());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException () {
        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNull() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "Pesho", "Gosho", "Stamat");
        this.names.addAll(collection);
        this.names.joinWith(null);
    }

    @Test
    public void testJoinWorksFine() {
        List<String> collection = new ArrayList<>();
        Collections.addAll(collection, "Pesho", "Gosho", "Stamat");
        this.names.addAll(collection);
        Assert.assertEquals("Gosho, Pesho, Stamat", this.names.joinWith(", "));
    }
}