package test;

import app.waste_disposal.annotations.Disposable;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.GarbageProcessor;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.StrategyHolder;
import app.waste_disposal.DefaultGarbageProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import test.fakes.DisposableAnnotation;
import test.fakes.DisposableWaste;
import test.fakes.NonAnnotationWaste;
import test.fakes.NonDisposableWaste;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultGarbageProcessorTest {

    private Map<Class, GarbageDisposalStrategy> fakeStrategiesMap;
    private GarbageProcessor garbageProcessor;
    private StrategyHolder strategyHolderMock;
    private ProcessingData processingDataMock;
    private GarbageDisposalStrategy garbageStrategyMock;

    @Before
    public void initial(){
        this.strategyHolderMock = mock(StrategyHolder.class);

        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolderMock);
        this.processingDataMock = mock(ProcessingData.class);
        this.garbageStrategyMock = mock(GarbageDisposalStrategy.class);
        this.strategyHolderMock.addStrategy(DisposableAnnotation.class, this.garbageStrategyMock);
        this.fakeStrategiesMap = new LinkedHashMap<>();
        this.fakeStrategiesMap.put(DisposableAnnotation.class, this.garbageStrategyMock);
    }

    @Test
    public void getStrategyHolderToReturnStrategyHolder() {
        Assert.assertSame("Return type is not StartegyHolder", this.strategyHolderMock, this.garbageProcessor.getStrategyHolder());
    }

    @Test(expected = IllegalArgumentException.class)
    public void processWasteThrowErrorWhenNonDisposableAnnotatedWasteIsPassed() {
        this.garbageProcessor.processWaste(new NonDisposableWaste());
    }

    @Test(expected = IllegalArgumentException.class)
    public void processWasteThrowErrorWhenNonAnnotatedWasteIsPassed() {
        this.garbageProcessor.processWaste(new NonAnnotationWaste());
    }

    @Test
    public void processWasteReturnProcessingDateWhenDisposableAnnotatedWasteIsPassed() {

        when(this.garbageStrategyMock.processGarbage(Mockito.isA(DisposableWaste.class))).thenReturn(this.processingDataMock);
        when(this.strategyHolderMock.getDisposalStrategies()).thenReturn(this.fakeStrategiesMap);
        ProcessingData processingData =  this.garbageProcessor.processWaste(new DisposableWaste());

        Assert.assertSame(this.processingDataMock, processingData);
    }

}