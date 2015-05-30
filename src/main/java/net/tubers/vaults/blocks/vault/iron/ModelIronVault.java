package net.tubers.vaults.blocks.vault.iron;

import java.util.ArrayList;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelIronVault extends ModelBase 
	{
		
		private ArrayList<ModelRenderer> parts;
	    
		public ModelRenderer vaultDoor;

	    public ModelIronVault()
	    {
	    	parts = new ArrayList<ModelRenderer>();
	    	
	    	ModelRenderer vaultBody = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		    vaultBody.addBox(-7F, -8F, -7F, 
		        			  14,  16,  10);  
		    vaultBody.setRotationPoint(8, 8, 8);
		    parts.add(vaultBody);
		    
		    vaultDoor = (new ModelRenderer(this, 0, 26)).setTextureSize(64, 64);
		    vaultDoor.addBox(-12.8F, -7.999F,   0F, 
		        		      14,  16,  4);  
		    vaultDoor.setRotationPoint(13.8F, 8, 11);
		    parts.add(vaultDoor);
		    
		    ModelRenderer vaultWheelBase = (new ModelRenderer(this, 0, 0)).setTextureSize(64,64);
		    vaultWheelBase.addBox(1F, 1F,  -0.5F,
		    				  2,  2,  1);
		    vaultWheelBase.setRotationPoint(-7.8F,-2,4.5F);
		    vaultDoor.addChild(vaultWheelBase);
		    
		    
		    ModelRenderer vaultWheelSpoke1 = (new ModelRenderer(this, 0, 46)).setTextureSize(64,64);
		    vaultWheelSpoke1.addBox(-4F, -0.5F,  -0.5F,
  				  8,  1,  1);
		    vaultWheelSpoke1.setRotationPoint(2,2,1);
		    vaultWheelSpoke1.rotateAngleZ = (float) ((Math.PI)*1.3/8);
		    vaultWheelBase.addChild(vaultWheelSpoke1);
		    
		    ModelRenderer vaultWheelSpoke2 = (new ModelRenderer(this, 0, 46)).setTextureSize(64,64);
		    vaultWheelSpoke2.addBox(-4F, -0.5F,  -0.499F,
  				  8,  1,  1);
		    vaultWheelSpoke2.setRotationPoint(2,2,1);
		    vaultWheelSpoke2.rotateAngleZ = (float) -((Math.PI)*1.3/8);
		    vaultWheelBase.addChild(vaultWheelSpoke2);
		    
		    ModelRenderer vaultWheelSpoke3 = (new ModelRenderer(this, 0, 46)).setTextureSize(64,64);
		    vaultWheelSpoke3.addBox(-4F, -0.5F,  -0.4999F,
  				  8,  1,  1);
		    vaultWheelSpoke3.setRotationPoint(2,2,1);
		    vaultWheelSpoke3.rotateAngleZ = (float) (Math.PI/2);
		    vaultWheelBase.addChild(vaultWheelSpoke3);
		    
	        
	    }

	    /**
	     * This method renders out all parts of the chest model.
	     */
	    public void renderAll()
	    {
	    	for (ModelRenderer part : parts)
	    	{
	    		part.render(0.0625F);
	    	}
	    }
	    
	    // REFERENCES
	    /*
	     this.vaultBody = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
	    	
	     this.vaultBody.addBox(-8F, -8F, -8F, 
	        						16, 16, 16);
	      
	     this.vaultBody.setRotationPoint(8, 8, 8);
	    	
	     //vaultBody.rotateAngleY = 90;
	     
	     for texture 
	      	  z*x, z*x
	     y*z, y*x, y*z, y*x
	     */
	    
	}

