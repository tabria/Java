package test;


import app.waste_disposal.DefaultStrategyHolder;
import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.StrategyHolder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import test.fakes.DisposableAnnotation;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.booleanThat;
import static org.mockito.Mockito.mock;

public class DefaultStrategyHolderTest {

    private StrategyHolder strategyHolder;
    private GarbageDisposalStrategy garbageStrategy;
    private Map<Class, GarbageDisposalStrategy> fakeStrategiesMap;

    @Before
    public void init(){
        this.strategyHolder = new DefaultStrategyHolder();
        this.garbageStrategy = mock(GarbageDisposalStrategy.class);
        this.fakeStrategiesMap = new LinkedHashMap<>();
    }

    @Test
    public void testGetDisposalStrategiesToReturnMap() {

        Assert.assertEquals("getDisposalStrategies do not return correct type", this.fakeStrategiesMap, this.strategyHolder.getDisposalStrategies());
    }

    @Test
    public void testAddStrategyMustReturnTrueWhenPassingDisposableStrategy() {

        boolean expected = true;
        boolean result = this.strategyHolder.addStrategy(DisposableAnnotation.class, this.garbageStrategy);

        Assert.assertEquals("Add Strategy do not add strategies", expected, result);
    }

    @Test
    public void testAddStrategyMustReturnFalseWhenPassingAlreadyAddedDisposableStrategy() {

        boolean firstPut = this.strategyHolder.addStrategy(DisposableAnnotation.class, this.garbageStrategy);

        boolean expected = false;
        boolean result = this.strategyHolder.addStrategy(DisposableAnnotation.class, this.garbageStrategy);

        Assert.assertEquals("Add Strategy do not add strategies", expected, result);
    }

    @Test
    public void testRemoveStrategyMustDecreaseMapSize() {

    }

}