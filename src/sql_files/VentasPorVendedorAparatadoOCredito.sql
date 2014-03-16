SELECT F.Fecha,F.`idFactura` AS NumFactura, F.Nota AS Descripcion ,
SUM(PCF.`Cantidad`) AS TotalItem,FP.Saldo, (F.`TotalTarjeta`+F.`TotalContado`) 
AS TotalFacturado 
FROM factura AS F, productocantidadfact AS PCF, persona AS V, 
Facturaspendientes AS FP
WHERE F.`idVendedor`=V.`idPersona` AND PCF.`idFactura` = F.`idFactura` 
AND V.`Nombre` =?  AND SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.Concepto=?
AND F.`idFactura`=FP.`idFactura` AND F.`Estado` = "A" AND FP.`idVersionFactPendientes` = F.`idVersionFactura`
AND F.`idVersionFactura` =PCF.`idVersionFacturasProducto`
GROUP BY F.`idFactura`;