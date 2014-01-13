SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
SUM(PCF.`Cantidad`) AS TotalItem,F.TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS V
WHERE F.`idVendedor`=V.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND V.`Nombre` =?  AND F.Fecha BETWEEN ? AND ? AND F.Concepto="Cancelada"
GROUP BY F.`idFactura`;