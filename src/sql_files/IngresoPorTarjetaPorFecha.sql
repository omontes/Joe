SELECT SUM(F.`TotalTarjeta`)
FROM Factura AS F
WHERE SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.`Estado` = "A";
-- SELECT F.Fecha ,Per.`Nombre` AS Cliente,F.idFactura AS NumFact,
-- SUM(PCF.`Cantidad`) AS TotalItem,F.Descuento,
-- ((F.`TotalTarjeta`+F.`TotalContado`) / (1 - ((F.Descuento) / 100))) AS SubTotal,(F.`TotalTarjeta`+F.`TotalContado`) AS TotalFacturado
-- FROM Factura AS F, productocantidadfact AS PCF, persona AS Per
-- WHERE SUBSTRING(F.Fecha,1,10) BETWEEN ? AND ? AND F.`TipoPago` = ? AND F.`Estado` = "A"
-- AND PCF.`idFactura`=F.`idFactura` AND F.`idCliente`=Per.`idPersona` 
-- AND F.`idVersionFactura` = PCF.`idVersionFacturasProducto`
-- GROUP BY F.idFactura;