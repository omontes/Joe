SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
SUM(PCF.`Cantidad`) AS TotalItem,(F.`TotalTarjeta`+F.`TotalContado`) AS TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS V
WHERE F.`idVendedor`=V.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND V.`Nombre` =?  AND SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.Concepto="Cancelada"
AND F.`Estado`="A" AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
GROUP BY F.`idFactura`;