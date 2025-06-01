package kotli.template.multiplatform.compose.data.settings.datastore

import kotli.engine.BaseFeatureProcessor
import kotli.engine.FeatureProcessor
import kotli.engine.FeatureTag
import kotli.engine.TemplateState
import kotli.engine.template.VersionCatalogRules
import kotli.engine.template.rule.CleanupMarkedBlock
import kotli.engine.template.rule.CleanupMarkedLine
import kotli.engine.template.rule.RemoveFile
import kotli.engine.template.rule.RemoveMarkedBlock
import kotli.engine.template.rule.RemoveMarkedLine
import kotli.template.multiplatform.compose.Rules
import kotli.template.multiplatform.compose.Tags
import kotli.template.multiplatform.compose.data.settings.common.CommonSettingsProcessor
import kotli.template.multiplatform.compose.platform.client.MobileAndDesktopProcessor
import kotli.template.multiplatform.compose.platform.client.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.js.JsPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.jvm.JvmPlatformProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object DataStoreProcessor : BaseFeatureProcessor() {

    const val ID = "data.settings.datastore"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.MobileAndDesktop
    override fun getWebUrl(state: TemplateState): String =
        "https://developer.android.com/kotlin/multiplatform/datastore"

    override fun getIntegrationUrl(state: TemplateState): String =
        "https://developer.android.com/kotlin/multiplatform/datastore#creating-datastore"

    override fun getIntegrationEstimate(state: TemplateState): Long = 2.hours.inWholeMilliseconds

    override fun canApply(state: TemplateState): Boolean {
        return state.getFeature(JsPlatformProcessor.ID) == null
    }

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        MobileAndDesktopProcessor::class,
        CommonSettingsProcessor::class,
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.DataBuildGradle,
            CleanupMarkedLine("{data.settings.datastore}")
        )
        state.onApplyRules(
            Rules.ClientPlatformConfigKt,
            CleanupMarkedBlock("{data.settings.datastore}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.DataStoreSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ClientPlatformConfigKt,
            RemoveMarkedBlock("{data.settings.datastore}"),
            RemoveMarkedLine("DataStoreSource"),
            RemoveMarkedLine("SettingsSource")
        )
        state.onApplyRules(
            Rules.DataBuildGradle,
            RemoveMarkedLine("{data.settings.datastore}")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("androidx-datastore")
            )
        )
    }

}