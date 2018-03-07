package test;

import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import test.fakeClassesForTests.FakeDisposable;
import test.fakeClassesForTests.FakeDisposableWaste;
import test.fakeClassesForTests.FakeNonAnnotationalWaste;
import test.fakeClassesForTests.FakeNonDisposableWaste;

import java.lang.annotation.Annotation;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GarbageProcessorTest {

    private final Map<Class, GarbageDisposalStrategy> fakeStrategy = new LinkedHashMap<>();

    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolderMock;
    private ProcessingData processingDataMock;

    @Before
    public void initialize() {
        this.strategyHolderMock = Mockito.mock(StrategyHolder.class);
        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolderMock);
        this.processingDataMock = Mockito.mock(ProcessingData.class);


    }
    //test reduce points from 10 to 4
    @Test
    public void returnStrategyHolder() {
        Assert.assertSame("Return value is not strategyHolder type", this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwErrorWhenNonDisposableGarbage() {
        Waste nonDisposableWaste = new FakeNonDisposableWaste();

        this.garbageProcessor.processWaste(nonDisposableWaste);

    }

    @Test(expected = IllegalArgumentException.class)
    public void throwErrorWhenNonAnnotationalGarbage() {
        Waste nonAnotationalWaste = new FakeNonAnnotationalWaste();

        this.garbageProcessor.processWaste(nonAnotationalWaste);

    }

    //reduce from 6 to 4
    @Test(expected = IllegalArgumentException.class)
    public void throwErrorWhenNonContainingStrategy() {
        Map<Class, GarbageDisposalStrategy> fakeStrategy = new LinkedHashMap<>();

        Mockito.when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(fakeStrategy);

        this.garbageProcessor.processWaste(new FakeDisposableWaste());

    }

    //reduce result to 0
    @Test
    public void returnCorrectValue() {


        Mockito.when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(this.fakeStrategy);

        GarbageDisposalStrategy strategyMock = Mockito.mock(GarbageDisposalStrategy.class);
        Mockito.when(strategyMock.processGarbage(Mockito.isA(FakeDisposableWaste.class))).thenReturn(this.processingDataMock);

        this.fakeStrategy.put(FakeDisposable.class, strategyMock);

        ProcessingData processingData = this.garbageProcessor.processWaste(new FakeDisposableWaste());

        Assert.assertSame( this.processingDataMock, processingData);

    }

}