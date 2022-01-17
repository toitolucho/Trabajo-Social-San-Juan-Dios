package org.quarkbit.trabajosocialsanjuan.dao.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.quarkbit.trabajosocialsanjuan.dao.domain.Proveedor;
import org.quarkbit.trabajosocialsanjuan.dao.domain.ProveedorExample;

public interface ProveedorMapper {
    /**
     * 
     * table proveedores
     *
     * 
     */
    int countByExample(ProveedorExample example);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int deleteByExample(ProveedorExample example);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int deleteByPrimaryKey(Integer codigoProveedor);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int insert(Proveedor record);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int insertSelective(Proveedor record);

    /**
     * 
     * table proveedores
     *
     * 
     */
    List<Proveedor> selectByExample(ProveedorExample example);

    /**
     * 
     * table proveedores
     *
     * 
     */
    Proveedor selectByPrimaryKey(Integer codigoProveedor);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int updateByExampleSelective(@Param("record") Proveedor record, @Param("example") ProveedorExample example);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int updateByExample(@Param("record") Proveedor record, @Param("example") ProveedorExample example);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int updateByPrimaryKeySelective(Proveedor record);

    /**
     * 
     * table proveedores
     *
     * 
     */
    int updateByPrimaryKey(Proveedor record);
    
    public int obtenerUltimoId(Map<String, Integer> dato);
}