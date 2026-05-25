package com.SprintXXL.primitivetoolworks.feature.tools.tooltip;

import java.util.List;

public interface TooltipComponent {
    void addLines(TooltipContext context, List<String> tooltip);
}
