SELECT DISTINCT F.idFactura AS NumCredito,FP.Saldo,FP.FechaVencimiento,(SELECT FPP.`Saldo`+SUM(PFPP.`PagoContado`)+SUM(PFPP.`PagoTarjeta`) FROM Factura AS FF,FacturasPendientes AS FPP,PagosFactPendientes AS PFPP WHERE
FF.idFactura=F.idFactura AND FF.Estado='A'AND FF.idFactura=FP.idFactura AND FF.idVersionFactura=FPP.idVersionFactPendientes AND PFPP.idFacturaPendiente = FPP.idFactura AND PFPP.idFacturaVersionPagosPend = FPP.idVersionFactPendientes
) AS Total,C.Nombre AS Cliente,V.Nombre AS Vendedor
FROM Factura AS F,FacturasPendientes AS FP, Persona AS C, Persona AS V, PagosFactPendientes AS PFP
WHERE F.Concepto='Credito' AND F.Estado='A' AND F.idFactura=FP.idFactura AND F.idCliente=C.idPersona AND F.idVendedor=V.idPersona 
AND F.idVersionFactura=FP.idVersionFactPendientes AND PFP.idFacturaPendiente = FP.idFactura AND PFP.idFacturaVersionPagosPend = FP.idVersionFactPendientes
ORDER BY F.idFactura DESC LIMIT 100;
