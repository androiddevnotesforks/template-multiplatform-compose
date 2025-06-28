# Usage

## Overview

**Component**: `shared.presentation.ui.component.DsMarkdown`  

The component provides a general facade to abstract the underlying framework, allowing for easier replacement or modification in the future.

## Example

```kotlin
@Composable
fun DsMarkdownUsage() {
    DsMarkdown(text = """
        # h1 Heading
        ## h2 Heading
        ### h3 Heading
        #### h4 Heading
        ##### h5 Heading
        ###### h6 Heading    
    """.trimIndent())
}
```
