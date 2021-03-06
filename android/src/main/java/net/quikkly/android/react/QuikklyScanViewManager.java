package net.quikkly.android.react;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class QuikklyScanViewManager extends SimpleViewManager<QuikklyScanView> {
    private static final String TAG = "QuikklyScanViewManager";
    private static final String REACT_CLASS = "QuikklyScanView";

    @Nonnull
    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Nullable
    @Override
    @SuppressWarnings("unchecked")
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return (Map)MapBuilder.builder().put("scanCode",
                MapBuilder.of("phasedRegistrationNames",
                        MapBuilder.of("bubbled", "onScanCode")))
                .build();
    }

    @Nonnull
    @Override
    protected QuikklyScanView createViewInstance(@Nonnull ThemedReactContext context) {
        return new QuikklyScanView(context);
    }

    @Override
    public void onDropViewInstance(QuikklyScanView view) {
        super.onDropViewInstance(view);
        view.cleanupView();
    }

    @ReactProp(name = "cameraPreviewFit")
    public void setCameraPreviewFit(QuikklyScanView view, Integer cameraPreviewFit) {
        view.setCameraPreviewFit(cameraPreviewFit);
    }

}
