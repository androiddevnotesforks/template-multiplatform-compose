package kotli.template.multiplatform.compose.foundation.di

import kotli.engine.FeatureProcessor
import kotli.template.multiplatform.compose.foundation.di.koin.KoinProcessor
import kotli.template.multiplatform.compose.foundation.FoundationProvider

object DIProvider : FoundationProvider() {

    override fun getId(): String = "foundation.di"
    override fun createProcessors(): List<FeatureProcessor> = listOf(
        KoinProcessor
    )

}