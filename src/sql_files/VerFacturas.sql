SELECT F.idFactura AS NumFact,F.Fecha,C.Nombre AS Cliente,V.Nombre AS Vendedor,F.Tipopago AS TipoPago,F.TotalFacturado AS Total 
FROM factura AS F,persona AS C, persona AS V
WHERE F.Estado ='Cerrada' AND F.idCliente=C.idPersona AND V.idPersona=F.idVendedor
ORDER BY F.idFactura DESC LIMIT 100;