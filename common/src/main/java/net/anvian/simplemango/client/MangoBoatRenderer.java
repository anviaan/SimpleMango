package net.anvian.simplemango.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Quaternion;
import com.mojang.math.Vector3f;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.vehicle.Boat;
import org.jetbrains.annotations.NotNull;

public final class MangoBoatRenderer extends EntityRenderer<Boat> {
    private static final ResourceLocation BOAT_TEXTURE =
            new ResourceLocation("simplemango", "textures/entity/boat/mango.png");
    private static final ResourceLocation CHEST_BOAT_TEXTURE =
            new ResourceLocation("simplemango", "textures/entity/chest_boat/mango.png");

    private final BoatModel model;
    private final ResourceLocation texture;

    public MangoBoatRenderer(EntityRendererProvider.Context context, boolean chestBoat) {
        super(context);
        this.shadowRadius = 0.8F;
        this.model = new BoatModel(
                context.bakeLayer(
                        chestBoat
                                ? ModelLayers.createChestBoatModelName(Boat.Type.OAK)
                                : ModelLayers.createBoatModelName(Boat.Type.OAK)),
                chestBoat);
        this.texture = chestBoat ? CHEST_BOAT_TEXTURE : BOAT_TEXTURE;
    }

    @Override
    public void render(
            Boat boat,
            float entityYaw,
            float partialTick,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight) {
        poseStack.pushPose();
        poseStack.translate(0.0D, 0.375D, 0.0D);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F - entityYaw));
        float hurtTime = boat.getHurtTime() - partialTick;
        float damage = boat.getDamage() - partialTick;
        if (damage < 0.0F) {
            damage = 0.0F;
        }
        if (hurtTime > 0.0F) {
            poseStack.mulPose(
                    Vector3f.XP.rotationDegrees(Mth.sin(hurtTime) * hurtTime * damage / 10.0F * boat.getHurtDir()));
        }
        float bubbleAngle = boat.getBubbleAngle(partialTick);
        if (!Mth.equal(bubbleAngle, 0.0F)) {
            poseStack.mulPose(new Quaternion(new Vector3f(1.0F, 0.0F, 1.0F), bubbleAngle, true));
        }
        poseStack.scale(-1.0F, -1.0F, 1.0F);
        poseStack.mulPose(Vector3f.YP.rotationDegrees(90.0F));
        model.setupAnim(boat, partialTick, 0.0F, -0.1F, 0.0F, 0.0F);
        VertexConsumer vertexConsumer = buffer.getBuffer(model.renderType(texture));
        model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        if (!boat.isUnderWater()) {
            VertexConsumer waterConsumer = buffer.getBuffer(RenderType.waterMask());
            model.waterPatch().render(poseStack, waterConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        }
        poseStack.popPose();
        super.render(boat, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(Boat boat) {
        return texture;
    }
}
