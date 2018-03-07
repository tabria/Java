package app.waste_disposal.annotations;


import java.lang.annotation.*;

@Disposable
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Burn {
}
