package org.apache.commons.imaging.formats.tiff.fieldtypes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FieldTypeTest{

  @Test
  public void testGetFieldTypeWithNegative() {
      try { 
        FieldType.getFieldType((-748));
        fail("Expecting exception: Exception");
      } catch(Exception e) {
         assertEquals("Field type -748 is unsupported",e.getMessage());
         assertEquals(FieldType.class.getName(), e.getStackTrace()[0].getClassName());
      }
  }

}