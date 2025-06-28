package kotli.template.multiplatform.compose.data.database.room

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
import kotli.template.multiplatform.compose.common.CommonKspProcessor
import kotli.template.multiplatform.compose.data.database.DatabaseCommonProcessor
import kotli.template.multiplatform.compose.data.database.SqliteProcessor
import kotli.template.multiplatform.compose.platform.client.MobileAndDesktopProcessor
import kotli.template.multiplatform.compose.platform.client.android.AndroidPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.ios.IOSPlatformProcessor
import kotli.template.multiplatform.compose.platform.client.jvm.JvmPlatformProcessor
import kotlin.reflect.KClass
import kotlin.time.Duration.Companion.hours

object RoomProcessor : BaseFeatureProcessor() {

    const val ID = "data.database.room"

    override fun getId(): String = ID
    override fun getTags(): List<FeatureTag> = Tags.MobileAndDesktop
    override fun getIntegrationEstimate(state: TemplateState): Long = 4.hours.inWholeMilliseconds
    override fun getWebUrl(state: TemplateState): String =
        "https://developer.android.com/kotlin/multiplatform/room"

    override fun getIntegrationUrl(state: TemplateState): String =
        "https://developer.android.com/kotlin/multiplatform/room#defining-database"

    override fun canApply(state: TemplateState): Boolean {
        return listOfNotNull(
            state.getFeature(AndroidPlatformProcessor.ID),
            state.getFeature(IOSPlatformProcessor.ID),
            state.getFeature(JvmPlatformProcessor.ID)
        ).isNotEmpty()
    }

    override fun dependencies(): List<KClass<out FeatureProcessor>> = listOf(
        MobileAndDesktopProcessor::class,
        DatabaseCommonProcessor::class,
        CommonKspProcessor::class,
        SqliteProcessor::class,
    )

    override fun doApply(state: TemplateState) {
        state.onApplyRules(
            Rules.ClientBuildGradle,
            CleanupMarkedBlock("{data.database.room.config}"),
            CleanupMarkedLine("{data.database.room}")
        )
        state.onApplyRules(
            Rules.ClientPlatformConfigKt,
            CleanupMarkedBlock("{data.database.room}")
        )
    }

    override fun doRemove(state: TemplateState) {
        state.onApplyRules(
            Rules.ClientBuildGradle,
            RemoveMarkedBlock("{data.database.room.config}"),
            RemoveMarkedLine("{data.database.room}")
        )
        state.onApplyRules(
            VersionCatalogRules(
                RemoveMarkedLine("androidx-room")
            )
        )
        state.onApplyRules(
            Rules.RoomSource,
            RemoveFile()
        )
        state.onApplyRules(
            Rules.RoomDir,
            RemoveFile()
        )
        state.onApplyRules(
            "app/schemas",
            RemoveFile()
        )
        state.onApplyRules(
            Rules.ClientCommonConfigKt,
            RemoveMarkedLine("RoomSource")
        )
        state.onApplyRules(
            Rules.ClientPlatformConfigKt,
            RemoveMarkedBlock("{data.database.room}"),
            RemoveMarkedLine("room")
        )
    }

}