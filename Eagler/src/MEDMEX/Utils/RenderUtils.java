package MEDMEX.Utils;





import net.lax1dude.eaglercraft.EaglerAdapter;
import net.lax1dude.eaglercraft.adapter.Tessellator;
import net.minecraft.src.AxisAlignedBB;


public class RenderUtils {
	
	private static float red;

    /** Used to specify new blue value for the current color. */
    private static float blue;

    /** Used to specify new green value for the current color. */
    private static float green;

    /** Used to speify new alpha value for the current color. */
    private static float alpha;
	
	public static void drawOutlinedBoundingBox(AxisAlignedBB aa) {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawing(3);
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.draw();
		tessellator.startDrawing(3);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.draw();
		tessellator.startDrawing(1);
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.draw();
	}
	
	public static void drawBoundingBox(AxisAlignedBB aa)  {
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.addVertex(aa.minX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.maxZ);
		tessellator.addVertex(aa.minX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.minX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.minZ);
		tessellator.addVertex(aa.maxX, aa.maxY, aa.maxZ);
		tessellator.addVertex(aa.maxX, aa.minY, aa.maxZ);
		tessellator.draw();
	}


	public static void drawSolidEntityESP(double x, double y, double z, double width, double height, int color) {
		EaglerAdapter.glPushMatrix();
		EaglerAdapter.glEnable(EaglerAdapter.GL_BLEND);
		EaglerAdapter.glBlendFunc(770, 771);
		// EaglerAdapter.glDisable(EaglerAdapter.GL_LIGHTING);
		EaglerAdapter.glDisable(EaglerAdapter.GL_TEXTURE_2D);
		EaglerAdapter.glEnable(2848);
		EaglerAdapter.glDisable(EaglerAdapter.GL_DEPTH_TEST);
		EaglerAdapter.glDepthMask(false);
		red = (float)(color >> 16 & 255) / 255.0F;
	    blue = (float)(color >> 8 & 255) / 255.0F;
	    green = (float)(color & 255) / 255.0F;
	    alpha = (float)(color >> 24 & 255) / 255.0F;
		EaglerAdapter.glColor4f(red, green, blue, alpha);
		drawBoundingBox(new AxisAlignedBB(x - width, y, z - width, x + width , y + height, z + width));
		EaglerAdapter.glDisable(2848);
		EaglerAdapter.glEnable(EaglerAdapter.GL_TEXTURE_2D);
		// EaglerAdapter.glEnable(EaglerAdapter.GL_LIGHTING);
		EaglerAdapter.glEnable(EaglerAdapter.GL_DEPTH_TEST);
		EaglerAdapter.glDepthMask(true);
		EaglerAdapter.glDisable(EaglerAdapter.GL_BLEND);
		EaglerAdapter.glPopMatrix();
	}
	
	
	public static void drawLine3D(float x, float y, float z, float x1, float y1, float z1, float thickness, int hex)
    {
        float red = (hex >> 16 & 0xFF) / 255.0F;
        float green = (hex >> 8 & 0xFF) / 255.0F;
        float blue = (hex & 0xFF) / 255.0F;
        float alpha = (hex >> 24 & 0xFF) / 255.0F;

        EaglerAdapter.glPushMatrix();
        EaglerAdapter.glDisable(3553 /*GL_TEXTURE_2D*/);
        EaglerAdapter.glEnable(3042 /*GL_BLEND*/);
        EaglerAdapter.glDisable(3008 /*GL_ALPHA*/);
        EaglerAdapter.glBlendFunc(770, 771);
        EaglerAdapter.glShadeModel(EaglerAdapter.GL_SMOOTH);
        EaglerAdapter.glLineWidth(thickness);
        EaglerAdapter.glEnable(2848);
        EaglerAdapter.glDisable(2929 /*GL_DEPTH_TEST*/);
        EaglerAdapter.glEnable(34383);
        final Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawing(1);
        tessellator.setColorRGBA_F(red, green, blue, alpha);
        tessellator.addVertex((double) x, (double) y, (double) z);
        tessellator.addVertex((double) x1, (double) y1, (double) z1);
        tessellator.draw();
        EaglerAdapter.glShadeModel(EaglerAdapter.GL_FLAT);
        EaglerAdapter.glDisable(2848);
        EaglerAdapter.glEnable(2929 /*GL_DEPTH_TEST*/);
        EaglerAdapter.glDisable(34383);
        EaglerAdapter.glDisable(3042 /*GL_BLEND*/);;
        EaglerAdapter.glEnable(3008 /*GL_ALPHA*/);
        EaglerAdapter.glEnable(3553 /*GL_TEXTURE_2D*/);
        EaglerAdapter.glPopMatrix();
    }
	


	  
	 
	
	
	 
	
	
	

	
}
