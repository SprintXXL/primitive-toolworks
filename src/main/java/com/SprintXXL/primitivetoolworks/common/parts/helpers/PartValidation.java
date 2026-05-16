package com.SprintXXL.primitivetoolworks.common.parts.helpers;

import com.SprintXXL.primitivetoolworks.common.materials.MaterialIDs;
import com.SprintXXL.primitivetoolworks.common.parts.PartIDs;

public class PartValidation {

    public static boolean isValidMaterialPartCombo(String materialID, String partID) {

        if (materialID == null || partID == null) {
            return false;
        }

        if (materialID.equals(MaterialIDs.FLINT) &&  partID.equals(PartIDs.PICKAXE_HEAD)) {
            return true;
        }
        if (materialID.equals(MaterialIDs.WOOD) && partID.equals(PartIDs.HANDLE)) {
            return true;
        }
        if (materialID.equals(MaterialIDs.BONE) && partID.equals(PartIDs.BINDING)) {
            return true;
        }
        return false;
    }
}
